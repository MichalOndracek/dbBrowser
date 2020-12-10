package cz.example.dbrowser.service;

import java.util.List;

public interface DatabaseService {

    List<String> getAllSchemas();

    List<String> getAllSchemaTables(String schema);

    List<String> getAllTableColumns(String table);
}
