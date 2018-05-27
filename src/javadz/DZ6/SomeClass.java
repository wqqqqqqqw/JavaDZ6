package javadz.DZ6;

import java.util.List;

public class SomeClass {

    private String stringField;
    private List<String> listOfStringsField;
    protected double doubleField;

    public SomeClass(String stringField, List<String> listOfStringsField, double doubleField) {
        this.stringField = stringField;
        this.listOfStringsField = listOfStringsField;
        this.doubleField = doubleField;
    }

    private String getStringField() {
        return this.stringField;
    }

    List<String> getlistOfStringsField() {
        return this.listOfStringsField;
    }

    @Skip
    private double getdoubleField() {
        return this.doubleField;
    }

    private void printStringAt(Integer listElement) {
        if (listOfStringsField != null) {
            try {
                System.out.println(listOfStringsField.get(listElement));
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    protected boolean SomeFoo(String str1, String str2, int limit) {
        return true;
    }
}
