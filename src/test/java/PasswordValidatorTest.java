import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    // this object should be tested
    private PasswordValidator validator;
    @Test
    @DisplayName("Contrasena con 8+ caracteres, mayuscula y digito es valido ")
    void deberiaRetornarTrueCuandoLaContrasenaEsValida (){
        validator = new PasswordValidator();
        boolean resultado = validator.isValid("Cibertec2026");
        assertTrue(resultado);
    }

    /// Contrasena con menos 8 caracteres es invalida
    @Test
    @DisplayName("Contrasena con menos de 8 caracteres es invalida")
    void deberiaRetornarFalseCuandoLaContrasenaEsMuyCorta(){
        validator = new PasswordValidator();
        boolean resultado = validator.isValid("ciber");
        assertFalse(resultado);
    }
    /// Contrsena sin digito valida
    @Test
    @DisplayName("Contraseña sin digito valida")
    void contraseñaSinDigito(){
        validator = new PasswordValidator();
        boolean resultado = validator.isValid("Cibertechsgsgc");
        assertFalse(resultado);
    }
    /// Contrasena null es invalida
    @Test
    @DisplayName("Contraseña null es invalida")
    void contraseñaNullInvalida(){
        validator = new PasswordValidator();
        // "" != null
        boolean resultado = validator.isValid(null);
        assertFalse(resultado);
    }
}