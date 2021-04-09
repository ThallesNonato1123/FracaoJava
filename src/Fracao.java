import static java.lang.Math.abs;

/**
 * Representa uma fração de forma explícita, guardando numerador e denominador inteiros.
 * Frações equivalentes (matematicamente) devem ser consideradas equals().
 */
public class Fracao {

    int numerador;
    int denominador;
    boolean sinal;
    float resultado;

    public Fracao(int numerador, int denominador) {

        if (denominador == 0) {
            throw new ArithmeticException("Denominador não pode ser zero!!");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    /**
     * Retorna o sinal da fração.
     *
     * @return true, se for positiva ou nula (zero);
     *         false, se for negativa.
     */
    public boolean getSinal() {
        this.sinal = numerador * denominador >= 0;
            return this.sinal;
    }

    /**
     * Retorna o (valor absoluto do) numerador desta fração, ou seja, sempre não-negativo
     * @return o numerador
     */
    public int getNumerador() {
        return abs(numerador);  // ToDo: IMPLEMENT ME!!!!
    }

    /**
     * Retorna o (valor absoluto do) denominador desta fração, ou seja, sempre positivo
     * @return o numerador
     */

    public int getDenominador() {
        return abs(denominador);
    }

    /**
     * Retorna o valor numérico da fração (com o sinal correto).
     *
     * @return um float, com o valor na melhor precisão possível
     *         Ex.: -1/3 vai retornar 0.33333333
     */
    public float getValorNumerico() {
        float a;
        float b;
        a = numerador;
        b = denominador;
        resultado = a/b;
        return resultado;  // ToDo: IMPLEMENT ME!!!!
    }

    /**
     * Retorna uma fração equivalente à esta fração,
     * e que não pode mais ser simplificada (irredutível).
     *
     * @return um outro objeto Fracao, se esta fração for redutível;
     *         esta própria fração (this), se ela já for irredutível
     */
    public Fracao getFracaoGeratriz() {
        int menor = Math.min(denominador, numerador);
        for(int i = 1 ; i <= menor; i++) {
            if(this.denominador % i == 0 && numerador % i == 0){
                this.denominador = denominador/i;
                this.numerador = numerador/i;
            }

        }
        return new Fracao(numerador,denominador);  // ToDo: IMPLEMENT ME!!!!
    }

    @Override
    public String toString() {
        String exp;
        if(!this.sinal) exp = '-' + this.numerador + "/" + this.denominador;
        else exp = this.numerador + "/" + this.denominador;
        return exp; // ToDo: IMPLEMENT ME!!!!
    }
}