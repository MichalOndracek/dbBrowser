package cz.example.dbrowser.controller;

import cz.example.dbrowser.service.DatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/database")
@AllArgsConstructor
public class DatabaseController {

    private final DatabaseService databaseService;

    @GetMapping
    public List<String> getAllSchemas() {
        return databaseService.getAllSchemas();
    }

    @GetMapping(value = "schema/{schemaName}")
    public List<String> getAllSchemaTables(@PathVariable String schemaName) {
        return databaseService.getAllSchemaTables(schemaName);
    }

    @GetMapping(value = "table/{tableName}")
    public List<String> getAllTableColumns(@PathVariable String tableName) {
        return databaseService.getAllTableColumns(tableName);
    }
}
