public class ServicioNotificaciones {

    private final EnviadorCorreos enviador;

    public ServicioNotificaciones(EnviadorCorreos enviador){
        this.enviador = enviador;
    }

    // notificar resultado
    public void notificarResultado(String correo, double nota){
        if (correo == null || correo.trim().isEmpty()){
            throw  new IllegalArgumentException("El correo no puede estar vacio");
        }

        if( nota >= 13 ){
            enviador.enviar(correo,"Felicidades, aprobaste con "+ nota);
        }else {
            enviador.enviar(correo, "Lo sentimos, tu no fue "+ nota);
        }
    }

    public void notificarGrupo(String[] correos, double nota){
        for (String correo: correos ){
            notificarResultado(correo, nota);
        }
    }

}
