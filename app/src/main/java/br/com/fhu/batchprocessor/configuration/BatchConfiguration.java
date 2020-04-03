package br.com.fhu.batchprocessor.configuration;

import br.com.fhu.batchprocessor.model.Person;
import br.com.fhu.batchprocessor.steps.processname.processor.JobCompletionNotificationListener;
import br.com.fhu.batchprocessor.steps.processname.processor.PersonItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    /**
     * Spring Boot Batch Job Configuration
     */
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step processNameStep) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(processNameStep)
                .end()
                .build();
    }

    /**
     * Spring Boot Batch Job Step Configuration
     */
    @Bean
    public Step processNameStep(JdbcCursorItemReader<Person> personReader,
                                JdbcBatchItemWriter<Person> personWriter) {
        return stepBuilderFactory.get("processNameStep")
                .<Person, Person> chunk(10)
                .reader(personReader)
                .processor(new PersonItemProcessor())
                .writer(personWriter)
                .build();
    }
}

