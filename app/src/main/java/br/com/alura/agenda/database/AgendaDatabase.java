package br.com.alura.agenda.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import br.com.alura.agenda.model.Aluno;

@Database(entities = {Aluno.class}, version = 2, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String NOME_BANDO_DE_DADOS = "agenda.db";

    public abstract AlunoDAO getRoomAlunoDAO();

    public static AgendaDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, AgendaDatabase.class, NOME_BANDO_DE_DADOS)
                .allowMainThreadQueries()
                .addMigrations(new Migration(1, 2) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("ALTER TABLE aluno ADD COLUMN sobrenome TEXT");
                        database.execSQL("ALTER TABLE aluno ADD COLUMN endereço TEXT");
                    }
                })/*, new Migration(2,3) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_novo`" +
                                "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                                "`nome` TEXT, " +
                                "`sobrenome` TEXT, " +
                                "`edereço` TEXT, " +
                                "`telefone` TEXT, " +
                                "`email` TEXT)");

                        database.execSQL("INSERT INTO Aluno_novo (id, " +
                                "nome, " +
                                "telefone, " +
                                "email)" +
                                "SELECT id, nome, telefone, email FROM Aluno");

                        database.execSQL("DROP TABLE Aluno");

                        database.execSQL("ALTER TABLE Aluno_novo RENAME TO Aluno");
                    }
                })*/
                .build();
    }
}