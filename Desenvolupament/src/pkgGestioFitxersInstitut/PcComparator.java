/**
 * 
 */
package pkgGestioFitxersInstitut;

import java.util.Comparator;

/**
 * @author Daniela
 *
 */
public class PcComparator implements Comparator<PC> {
    public int PcCompare(PC a, PC b) {
        int numeroComparison = a.PC.compareTo(b.PC);
        return numeroComparison == 0 ? a.aula.compareTo(b.aula) : numeroComparison;
    }

	@Override
	public int compare(PC o1, PC o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
