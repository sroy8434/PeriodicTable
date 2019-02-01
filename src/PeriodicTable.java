import java.util.List;

public class PeriodicTable
{
    private Element[] table;

    public PeriodicTable (int numOfElements)
    {
        table = new Element[numOfElements];
    }

    public boolean setElement (int i, Element e)
    {
        if (i < 0 || i >= table.length)
            return false;
        table[i] = e;
        return true;
    }

    public Element getElement(String symbol)
    {
        for (Element e : table)
            if (e.getSymbol().equals(symbol))
                return e;
        return null;
    }

    public List<Element> getFamily(String family)
    {

    }

    public String toString()
    {
        String output = "";
        for (Element e : table)
            output += e.toString() + "\n";

        return output;
    }

    public void sortByName()
    {

    }

    public void sortBySymbol()
    {

    }


}
