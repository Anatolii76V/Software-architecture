package ru.geekbrains.lesson6.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class NotesTable {

    private static Random random = new Random();

    private Collection<NotesRecord> records;

    public Collection<NotesRecord> getRecords() {
        prepareRecords();
        return records;
    }

    private void prepareRecords(){
        if (records == null){
            records = new ArrayList<>();
            int recordCount = random.nextInt(5, 11);
            for (int i = 0; i < recordCount; i++){
                records.add(new NotesRecord("title #" + (i + 1), "details #" + (i + 1)));
            }
        }
    }
}
