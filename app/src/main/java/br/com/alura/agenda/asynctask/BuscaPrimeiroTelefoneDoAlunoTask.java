package br.com.alura.agenda.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import br.com.alura.agenda.database.dao.TelefoneDAO;
import br.com.alura.agenda.model.Telefone;

public class BuscaPrimeiroTelefoneDoAlunoTask extends AsyncTask<Void, Void, Telefone> {

    private final TelefoneDAO dao;
    private final int alunoId;
    private final PrimeiroTelefoneEncontradoListener listener;

    public BuscaPrimeiroTelefoneDoAlunoTask(TelefoneDAO dao, int alunoId, PrimeiroTelefoneEncontradoListener litener) {
        this.dao = dao;
        this.alunoId = alunoId;
        this.listener = litener;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {
        return dao.buscaPrimeiroTelefoneDoAluno(alunoId);
    }

    @Override
    protected void onPostExecute(Telefone primeirotelefone) {
        super.onPostExecute(primeirotelefone);
        listener.quandoEncontrado(primeirotelefone);
    }

    public interface PrimeiroTelefoneEncontradoListener {
        void quandoEncontrado(Telefone telefoneEncontrado);
    }
}
