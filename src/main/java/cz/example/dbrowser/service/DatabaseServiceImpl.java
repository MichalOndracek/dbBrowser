package cz.example.dbrowser.service;


import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    @PersistenceContext
    private EntityManager entityManager;
    private Session session = null;

    public List<String> getAllSchemas(){
        if (entityManager == null || (session = entityManager.unwrap(Session.class)) == null) {
            throw new NullPointerException();
        }

        List<Object[]> schemas =
                session.createNativeQuery("select * from information_schema.schemata")
                        .list();

        return schemas.stream().map(it -> it[1].toString()).collect(Collectors.toList());
    }

    public List<String> getAllSchemaTables(String schema){
        if (entityManager == null || (session = entityManager.unwrap(Session.class)) == null) {
            throw new NullPointerException();
        }

        List<Object[]> tables =
                session.createNativeQuery("select * from information_schema.tables where table_schema = :schemaName")
                        .setParameter("schemaName", schema)
                        .list();

        return tables.stream().map(it -> it[2].toString()).collect(Collectors.toList());
    }

    public List<String> getAllTableColumns(String table){
        if (entityManager == null || (session = entityManager.unwrap(Session.class)) == null) {
            throw new NullPointerException();
        }

        List<Object[]> tables =
                session.createNativeQuery("select * from information_schema.columns where table_name = :tableName")
                        .setParameter("tableName", table)
                        .list();

        return tables.stream().map(it -> it[3].toString()).collect(Collectors.toList());
    }

}
