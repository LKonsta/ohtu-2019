
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukuJono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkionIndeksi;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        IntJoukkoMuuta(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        IntJoukkoMuuta(kapasiteetti, OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        IntJoukkoMuuta(kapasiteetti, kasvatuskoko);
    }
    
    private void IntJoukkoMuuta(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            return;
        }
        if (kasvatuskoko < 0) {
            return;
        }
        lukuJono = new int[kapasiteetti];
        for (int i = 0; i < lukuJono.length; i++) {
            lukuJono[i] = 0;
        }
        alkionIndeksi = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (alkionIndeksi == 0 || !(kuuluu(luku))) {
            lukuJono[alkionIndeksi] = luku;
            alkionIndeksi++;
            if (lukuJono[lukuJono.length-1] != 0) {
                int[] lukuJonoVanha = lukuJono;
                lukuJono = new int[alkionIndeksi + kasvatuskoko];
                kopioiTaulukko(lukuJonoVanha, lukuJono);
            }
            return true;
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkionIndeksi; i++) {
            if (luku == lukuJono[i]) {
                int kohta = i; //siis luku löytyy tuosta kohdasta :D
                lukuJono[kohta] = 0;
                for (int j = kohta; j < alkionIndeksi - 1; j++) {
                    lukuJono[j] = lukuJono[j + 1];
                }
                alkionIndeksi--;
                return true;
            }
        }
        return false;
    }
    
    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkionIndeksi; i++) {
            if (luku == lukuJono[i]) {
                return true;
            }
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int mahtavuus() {
        return alkionIndeksi;
    }
    
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        return muutos(a, b, 1);
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        return muutos(a, b, 2);
    }
    
    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        return muutos(a, b, 3);
    }
    
    public static IntJoukko muutos(IntJoukko a, IntJoukko b, int tapahtuma) {
        IntJoukko v = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        switch (tapahtuma) {
            case 1:
                for (int i = 0; i < aTaulu.length; i++) {
                    v.lisaa(aTaulu[i]);
                }   for (int i = 0; i < bTaulu.length; i++) {
                    v.lisaa(bTaulu[i]);
                }   break;
            case 2:
                for (int i = 0; i < aTaulu.length; i++) {
                    v.lisaa(aTaulu[i]);
                }   for (int i = 0; i < bTaulu.length; i++) {
                    v.poista(bTaulu[i]);
                }   break;
            case 3:
                for (int i = 0; i < aTaulu.length; i++) {
                    for (int j = 0; j < bTaulu.length; j++) {
                        if (aTaulu[i] == bTaulu[j]) {
                            v.lisaa(bTaulu[j]);
                        }
                    }
                }   break;
            default:
                break;
        }
        return v;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkionIndeksi];
        System.arraycopy(lukuJono, 0, taulu, 0, taulu.length);
        return taulu;
    }  
    
    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i < alkionIndeksi - 1; i++) {
            tuotos += lukuJono[i];
            tuotos += ", ";
        }
        if (alkionIndeksi != 0) {
            tuotos += lukuJono[alkionIndeksi - 1];
        }
        tuotos += "}";
        return tuotos;        
    }
}