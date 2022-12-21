package com.example.practica17;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.xml.sax.XMLReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.function.Function;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {
    private EditText textoBusqueda;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoBusqueda = findViewById(R.id.textoBusqueda);
        resultado = findViewById(R.id.textView);
        findViewById(R.id.botonBuscar).setOnClickListener(this::BuscarClick);
        findViewById(R.id.botonRest).setOnClickListener(this::restClick);
    }

    private void restClick(View view) {
    }

    private void BuscarClick(View view) {
    }

    private class BusquedaAsyncTask extends AsyncTask<String, Void, String> {

        private final Function<String, String> tarea;
        private final ProgressDialog dialogo;

        private BusquedaAsyncTask(String progressMsg, Function<String, String> task) {
            this.tarea = task;
            dialogo = new ProgressDialog(MainActivity.this);
            dialogo.setCancelable(true);
            dialogo.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialogo.setMessage(progressMsg);
        }

        protected void onPreExecute() {
            dialogo.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            return tarea.apply(strings[0]);
        }

        protected void onPostExecute(String s) {
            resultado.setText();
            dialogo.dismiss();
        }
    }

    private String consultaRest(String textoBusqueda) {
        try {
            URL url = new URL("https://books.google.com/books/feeds/volumen?q-\"");
            URLEncoder.encode(textoBusqueda,"UTF-8"+"\"");
            SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser parser=factory.newSAXParser();
            XMLReader reader= parser.getXMLReader();
            ManejadorXML manejadorXML=
            return manejadorXML.getResultado();
        } catch (MalformedURLException e) {
            return e.getLocalizedMessage();
        }
    }
}
