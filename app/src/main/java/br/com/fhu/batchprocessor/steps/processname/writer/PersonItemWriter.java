package br.com.fhu.batchprocessor.steps.processname.writer;

import br.com.fhu.batchprocessor.model.Person;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersonItemWriter {
    DataSource dataSource;

    private final String SQL = "UPDATE people SET first_name = :firstName, last_name = :lastName WHERE person_id = :id";

    public PersonItemWriter(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcBatchItemWriter<Person> personWriter() {
        return new JdbcBatchItemWriterBuilder<Person>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(SQL)
                .dataSource(dataSource)
                .build();
    }
}
