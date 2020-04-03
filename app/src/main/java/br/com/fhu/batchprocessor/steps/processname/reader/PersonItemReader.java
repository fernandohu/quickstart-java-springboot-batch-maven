package br.com.fhu.batchprocessor.steps.processname.reader;

import br.com.fhu.batchprocessor.model.PersonRowMapper;
import br.com.fhu.batchprocessor.model.Person;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersonItemReader {
    DataSource dataSource;

    private final String SQL = "SELECT * FROM people ORDER BY person_id DESC";

    public PersonItemReader(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcCursorItemReader<Person> personReader() {
        return new JdbcCursorItemReaderBuilder<Person>()
                .dataSource(dataSource)
                .name("personItemReader")
                .sql(SQL)
                .rowMapper(new PersonRowMapper())
                .maxRows(3)
                .build();
    }
}
