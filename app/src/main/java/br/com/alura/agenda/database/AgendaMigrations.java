package br.com.alura.agenda.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

class AgendaMigrations {

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE aluno ADD COLUMN sobrenome TEXT");
            database.execSQL("ALTER TABLE aluno ADD COLUMN endereço TEXT");
        }
    };
    public static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE aluno ADD COLUMN momentoDeCadastro INTEGER");
        }
    };
    static final Migration[] TODAS_MIGRATIONS = {MIGRATION_1_2, MIGRATION_2_3};
}














/*Migração para retornar ao banco de dados antigo "Exemplo"

  , new Migration(2,3) {
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
                })
*/