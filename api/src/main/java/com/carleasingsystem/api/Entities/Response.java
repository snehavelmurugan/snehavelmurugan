package com.carleasingsystem.api.Entities;

public class Response<T>
{
    private int status_code;
    private String message;
    private T effect;

    public Response()
    {
        super();
        this.status_code = 0;
        this.message ="nothing";
        this.effect = null;
    }

    public Response(int status_code, String message, T effect) 
    {
        this.status_code = status_code;
        this.message = message;
        this.effect = effect;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getT() {
        return effect;
    }

    public void setT(T effect) {
        this.effect = effect;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + status_code;
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((effect == null) ? 0 : effect.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Response<T> other = (Response<T>) obj;
        if (status_code != other.status_code)
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (effect == null) {
            if (other.effect != null)
                return false;
        } else if (!effect.equals(other.effect))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Response [status_code=" + status_code + ", message=" + message + ", effect=" + effect + "]";
    }
}