package com.ilab.storage.table.azurestoragetable;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.table.*;

public class AzureTableStorageOperations {

    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=https;"			+
                    "AccountName=" +(String)System.getenv("AccountName")+
                    "AccountKey="+(String)System.getenv("AccountKey")	;


    public static void main(String[] args) {
        try {
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

            // Create the table client.
            CloudTableClient tableClient = storageAccount.createCloudTableClient();

            // Loop through the collection of table names.
            for (String table : tableClient.listTables()) {
                // Output each table name.
                System.out.println(table);
            }
        } catch (Exception e) {
            // Output the stack trace.
            e.printStackTrace();
        }
    }
}
