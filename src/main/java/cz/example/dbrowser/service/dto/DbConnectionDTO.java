package cz.example.dbrowser.service.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class DbConnectionDTO {
    @NonNull
    private String name;
    @NonNull
    private String hostname;
    @NonNull
    private int port;
    @NonNull
    private String databaseName;
    @NonNull
    private String username;
    @NonNull
    private char[] password;
}
