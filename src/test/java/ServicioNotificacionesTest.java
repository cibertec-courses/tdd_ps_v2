import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServicioNotificacionesTest {

    // Mockito - enviador falso, no va a enviar correos
    private EnviadorCorreos enviadorFalso;


    private ServicioNotificaciones servicio;

    @BeforeEach
    void configurar(){
        enviadorFalso = mock(EnviadorCorreos.class);
        servicio = new ServicioNotificaciones(enviadorFalso);
    }

    /// Con not aprobatoria envia el mensaje de felicidades
    @Test
    @DisplayName("Con not aprobatoria envia el mensaje de felicidades")
    void deberiaEnviarFelicitacionesConUnaNotaAprobada(){
        String correo="jose@cibertec.edu.pe";
        servicio.notificarResultado(correo, 17.0);

        verify(enviadorFalso).enviar(correo, "Felicidades, aprobaste con 17.0");
    }

    /// Con nota desaprobatoria envia el mensaje de lamento
    @Test
    @DisplayName("Con nota desaprobatoria envia el mensaje de lamento")
    void deberiaEnviarLamentoConUnanotaDesaprobada(){
        String correo="jose@cibertec.edu.pe";
        servicio.notificarResultado(correo, 10.0);

        verify(enviadorFalso).enviar(correo, "Lo sentimos, tu no fue 10.0");
    }

}