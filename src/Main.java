import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {


        Vector<String> mappa = new Vector<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("D:\\Cose Pesanti\\University\\III ANNO\\ING. SOFTWARE\\Esercizi di Ricca\\AdventOfCode\\src\\input.txt"));
            try {
                mappa.add(bf.readLine());
                while (bf.ready()) {
                    mappa.add(bf.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        byr (Birth Year)
        iyr (Issue Year)
        eyr (Expiration Year)
        hgt (Height)
        hcl (Hair Color)
        ecl (Eye Color)
        pid (Passport ID)
        cid (Country ID)
         */

        //costruzione passaporto
        int i = 0;
        int contatore = 0;
        while (i < mappa.size()) {
            String passaporto = new String();
            for (int j = 1; j < mappa.size() - 1; j++) {
                if (mappa.size() > j + i)
                    if (!mappa.get(j + i).isEmpty()) {
                        passaporto += mappa.get(j + i);
                    } else {
                        i += j;
                        break;
                    }
                else {
                    i++;
                }
            }
            if (passaporto.contains("byr") &&
                    (passaporto.contains("iyr") &&
                            (passaporto.contains("eyr") &&
                                    (passaporto.contains("hgt") &&
                                            (passaporto.contains("hcl") &&
                                                    (passaporto.contains("ecl") &&
                                                            (passaporto.contains("pid")))))))) {
                contatore++;
            }
        }
        String lastPassport = "";
        int k = mappa.size() - 1;
        while (true) {
            if (!mappa.get(k).isEmpty()) {
                lastPassport += mappa.get(k);
                k--;
            } else
                break;
        }
        if (lastPassport.contains("byr") &&
                (lastPassport.contains("iyr") &&
                        (lastPassport.contains("eyr") &&
                                (lastPassport.contains("hgt") &&
                                        (lastPassport.contains("hcl") &&
                                                (lastPassport.contains("ecl") &&
                                                        (lastPassport.contains("pid")))))))) {
            contatore++;
        }

        System.out.println(contatore);
    }

}


