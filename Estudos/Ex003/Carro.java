package Estudos.Ex003;

public class Carro {
    private String modelo;
    private Motor motor;
    
    public Carro(String modelo, Motor motor) {
        try {
            if (modelo == null) {
                throw new IllegalArgumentException();
            } else if (motor == null) {
                throw new NullPointerException();
            } else if (motor.potencia < 50) {
                throw new RuntimeException();
            } else {
                this.modelo = modelo;
                this.motor = motor;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Modelo inválido!");
        } catch (NullPointerException e) {
            System.out.println("Motor não pode ser nulo!");
        } catch (RuntimeException e) {
            System.out.println("Potência do motor muito baixa!");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
