package com.hiringandtracking.config;

import com.hiringandtracking.entity.VhitOfferedStudentMaster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;


import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.database.support.DefaultDataFieldMaxValueIncrementerFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.File;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig{


    public static final Logger logger= LogManager.getLogger(SpringBatchConfig.class);
    @Autowired
    StudentMasterItemWriter itemWriter;

    @Autowired
    DataSource dataSource;



    @Bean
    public JdbcOperations jdbcOperations() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(transactionManager());
        factory.setIsolationLevelForCreate("ISOLATION_REPEATABLE_READ");
        factory.setTablePrefix("BATCH_");
        factory.setDatabaseType("MYSQL"); // set your database type here
        factory.setIncrementerFactory(new DefaultDataFieldMaxValueIncrementerFactory(dataSource));
        factory.setMaxVarCharLength(1000);
        factory.setJdbcOperations(jdbcOperations()); // set the jdbcOperations bean here
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @StepScope
    public FlatFileItemReader<VhitOfferedStudentMaster> itemReader(@Value("#{jobParameters[fullPathFileName]}") String pathToFIle) {
        logger.info("In FlatMapper");

        FlatFileItemReader<VhitOfferedStudentMaster> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource(new File(pathToFIle)));
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());

        logger.info("After FlatMapper");

        return flatFileItemReader;
    }

    @Bean
    public FieldSetMapper studentFieldSetMapper(){
        return new StudentFieldSetMapper();
    }

    private LineMapper<VhitOfferedStudentMaster> lineMapper() {
        DefaultLineMapper<VhitOfferedStudentMaster> lineMapper = new DefaultLineMapper<>();

        logger.info("In LineMapper");
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[] {"SL.NO.","First_Name","Last_Name","College_Email","Personal_Email","Aadhaar_No","Gender","Branch","Date_Of_Birth","Mobile_No","Offered_Date","Onboarding_Year","Hired_Through","College_Name","Degeree","Recruiter_Name","Job_Details"});

        //BeanWrapperFieldSetMapper<VHIT_OFFERED_STUDENT_MASTER> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        //fieldSetMapper.setTargetType(VHIT_OFFERED_STUDENT_MASTER.class);

        logger.info("After Target Setting");

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(studentFieldSetMapper());

        logger.info("entered");

        logger.info("Exiting line Mapper");

        return lineMapper;
    }

    @Bean
    public SkipPolicy skipPolicy() {
        return new ExceptionSkipPolicy();
    }

    @Bean
    public StudentDataProcessor processor() {
        logger.info("In processor");
        return new StudentDataProcessor();
    }

    @Bean
    public Step step1(FlatFileItemReader<VhitOfferedStudentMaster> itemReader, JobRepository jobRepository) {
        return new StepBuilder("sampleStep", jobRepository)
                .<VhitOfferedStudentMaster, VhitOfferedStudentMaster>chunk(10, transactionManager())
                .reader(itemReader)
                .processor(processor())
                .writer(itemWriter)
                .faultTolerant()
                .skipPolicy(skipPolicy())
                .build();
    }
    @Bean
    public Job runJob(FlatFileItemReader<VhitOfferedStudentMaster> itemReader,JobRepository jobRepository) {
        return new JobBuilder("importDataFromCSV", jobRepository)
                .start(step1(itemReader, jobRepository))
                .build();
    }





}
