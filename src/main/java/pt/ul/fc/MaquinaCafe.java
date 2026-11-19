package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Utilizar uma máquina de café. */
@StateSet({"desligada", "pronta", "aFazerCafe"})
public class MaquinaCafe {

    @StateRefinement(to="desligada(this)")
    public MaquinaCafe() {}

    /** Recolhe a chávena; a máquina fica pronta. */
    @StateRefinement(from="aFazerCafe(this)", to="pronta(this)")
    public void recolher() {}

    /** Descalcifica a máquina (continua desligada). */
    @StateRefinement(from="desligada(this)", to="desligada(this)")
    public void descalcificar() {}

    /** Começa a fazer um café. */
    @StateRefinement(from="pronta(this)", to="aFazerCafe(this)")
    public void fazerCafe() {}

    /** Desliga a máquina (cancela o café, se houver). */
    @StateRefinement(from="pronta(this) || aFazerCafe(this)", to="desligada(this)")
    public void desligar() {}

    /** Liga a máquina. */
    @StateRefinement(from="desligada(this)", to="pronta(this)")
    public void ligar() {}
}
