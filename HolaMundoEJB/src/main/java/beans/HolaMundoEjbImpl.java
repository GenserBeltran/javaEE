
package beans;

import javax.ejb.Stateless;

@Stateless
public class HolaMundoEjbImpl implements HolaMundoEjbRemote{

    @Override
    public int suma(int a, int b) {
        System.out.println("Ejecutando el metodo sumar desde el servidor");
        return a + b;
    }
    
}
