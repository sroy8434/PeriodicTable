import java.io.File;
import java.util.Scanner;

public class PeriodicTableDataReader
{
    public static void main(String[] args) throws Exception
    {
        String filename = "elements.csv";
        File inputFile = new File(filename);
        if (!inputFile.exists())
            System.out.println(filename + " cannot be found.");
        else
        {

            Scanner input = new Scanner(inputFile);

            int lineCount = 0;
            while (input.hasNextLine())
            {
                input.nextLine();
                lineCount++;
            }
            PeriodicTable pt = new PeriodicTable(lineCount);

            input.close();
            input = new Scanner(inputFile);

            String currentLine;
            String[] elementData;
            Element e;
            String name, symbol, family;
            int atomicNum, mostStableState;
            double weight;
            boolean metal;

            lineCount = 0;
            while (input.hasNextLine())
            {
                currentLine = input.nextLine();
                elementData = currentLine.split(",");
                name = elementData[0];
                atomicNum = Integer.parseInt(elementData[1]);
                symbol = elementData[2];
                weight = Double.parseDouble(elementData[3]);
                if (elementData[4].equals(""))
                    mostStableState = -999;
                else
                    mostStableState = Integer.parseInt(elementData[4]);
                family = elementData[5];
                if (elementData[6].equals("M"))
                    metal = true;
                else
                    metal = false;

                e = new Element(name, atomicNum, symbol, weight,
                        mostStableState, family, metal);

                pt.setElement(lineCount, e);
                lineCount++;
            } //end while hasNext
            input.close();

            System.out.println(pt);
            System.out.println();
/*
			pt.sortBySymbol();
			System.out.println(pt);
			System.out.println();

			Element foundEl = pt.find("N");
			System.out.println(foundEl);

			pt.sortByAtomicWeight();
			System.out.println(pt);
			System.out.println();

			MolecularWeight mWt = new MolecularWeight(pt);
			Wt.runMolecularWeight();
*/
        }
    }
}