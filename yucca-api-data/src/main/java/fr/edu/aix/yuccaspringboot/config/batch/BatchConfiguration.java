package fr.edu.aix.yuccaspringboot.config.batch;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import fr.edu.aix.yuccaspringboot.domain.Correction;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    // tag::readerwriterprocessor[]
   @Bean
    public FlatFileItemReader<Correction> reader() {
        return new FlatFileItemReaderBuilder<Correction>()
            .name("correctionItemReader")
            .resource(new ClassPathResource("sample-data.csv"))
            .delimited()
            .names(new String[]{"titre", "probleme"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<Correction>() {{
                setTargetType(Correction.class);
            }})
            .build();
    }

    @Bean
    public CorrectionItemProcessor processor() {
        return new CorrectionItemProcessor();
    }
/*
    @Bean
    public JdbcBatchItemWriter<Correction> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Correction>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
            .dataSource(dataSource)
            .build();
    }
*/
    @Bean
    public FlatFileItemWriter<Correction> fileWriter(List<? extends Correction> items) {
        Resource r = new FileSystemResource("resources/correction.csv");
        FlatFileItemWriter<Correction> ffiw = new FlatFileItemWriter<Correction>();
        ffiw.setResource(r);
        
        DelimitedLineAggregator<Correction> delimitedLineAggregator = new DelimitedLineAggregator<Correction>();       
        delimitedLineAggregator.setDelimiter(",");       
        
        
        BeanWrapperFieldExtractor<Correction> beanWrapperFiledExtractor = new BeanWrapperFieldExtractor<Correction>();
        String[] noms = new String[] {"titre" ,"probleme"};
        beanWrapperFiledExtractor.setNames(noms);
        
        delimitedLineAggregator.setFieldExtractor(beanWrapperFiledExtractor);
        ffiw.setLineAggregator(delimitedLineAggregator);
    	return ffiw;
        		
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
/*    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }
*/
/*
    @Bean
    public Job importUserJob2(JobCompletionNotificationListener listener, Step step2) {
        return jobBuilderFactory.get("importUserJob2")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step2)
            .end()
            .build();
    }
*/    
    @Bean
 	public Job job(JobCompletionNotificationListener listener, Step step1) {
 		return jobBuilderFactory.get("myJob")
 				.incrementer(new RunIdIncrementer())
 	            .listener(listener)
 				.start(step1)
 				.build();
 				//.next(step2) 				
 	}
/*   
    @Bean
    public Job importUserJob3(JobCompletionNotificationListener listener, Step step2) {
        return jobBuilderFactory.get("importUserJob2")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step2)
            .end()
            .build();
    }
*/
    
/*
    @Bean
    public Step step1(JdbcBatchItemWriter<Correction> writer) {
        return stepBuilderFactory.get("step1")
            .<Correction, Correction> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }
*/   
    @Bean
    public Step step2(FlatFileItemWriter<Correction> fileWriter) {
        return stepBuilderFactory.get("step2")
            .<Correction, Correction> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(fileWriter)
            .build();
    }
    // end::jobstep[]
}
