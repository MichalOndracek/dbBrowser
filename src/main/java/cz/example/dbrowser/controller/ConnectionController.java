package cz.example.dbrowser.controller;

import cz.example.dbrowser.domain.DbConnection;
import cz.example.dbrowser.service.ConnectionService;
import cz.example.dbrowser.service.dto.DbConnectionDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/connection")
@AllArgsConstructor
public class ConnectionController {

    private final ConnectionService connectionService;

    @PostMapping
    public DbConnection saveDbConnection(@RequestBody DbConnectionDTO dbConnection) {
        return connectionService.saveDbConnection(dbConnection);
    }

    @PutMapping(value = "{dbConnectionId}")
    public DbConnection updateDbConnection(
            @PathVariable Long dbConnectionId,
            @RequestBody DbConnectionDTO dbConnection) {

        return connectionService.updateDbConnection(dbConnectionId, dbConnection);
    }

    @DeleteMapping(value = "{dbConnectionId}")
    public void deleteDbConnection(@PathVariable Long dbConnectionId) {
        connectionService.deleteDbConnection(dbConnectionId);
    }

    @GetMapping(value = "{dbConnectionId}")
    public DbConnection getDbConnection(@PathVariable Long dbConnectionId) {
        return connectionService.getDbConnection(dbConnectionId);
    }

}
