package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistroUsuario extends AppCompatActivity {


    EditText edtUsuario, edtPassword, edtNombres, edtApellidos, edtDireccion, edtTelefono;

    Button btnGuardadDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        edtUsuario = (EditText)findViewById(R.id.edtUsuario);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        edtNombres = (EditText)findViewById(R.id.edtNombre);
        edtApellidos = (EditText)findViewById(R.id.edtApellidos);
        edtDireccion = (EditText)findViewById(R.id.edtDireccion);
        edtTelefono = (EditText)findViewById(R.id.edtTelefono);
        btnGuardadDatos=(Button)findViewById(R.id.btnGuardar);

        btnGuardadDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void registrarDatosUsuario(String url){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Usuario Registrado", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("usuario",edtUsuario.getText().toString());
                parametros.put("password",edtPassword.getText().toString());
                parametros.put("nombres",edtNombres.getText().toString());
                parametros.put("apellidos",edtApellidos.getText().toString());
                parametros.put("direccion",edtDireccion.getText().toString());
                parametros.put("telefono",edtTelefono.getText().toString());


                return parametros;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


}
