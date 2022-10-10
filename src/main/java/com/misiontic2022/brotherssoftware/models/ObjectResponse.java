package com.misiontic2022.brotherssoftware.models;

public class ObjectResponse {
    private Object object;
    private String mensaje;

    public ObjectResponse(Object object, String mensaje) {
        this.object = object;
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
