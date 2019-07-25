class Table {
    //Used to create a table with a header using an array of strings

    private String[] data;
    private String header;
    private int longest;

    public Table(String[] data, String header, int longest) {
        //Data is the array of rows in the table, header is the header for the table
        //longestString is the length of the longest row (used for right aligning)
        this.data = data;
        this.header = header;
        this.longest = longest;
    }

    public String toString() {
        //String representation
        String outstr = header + "\n";
        for (int i = 0; i < data.length; i ++) {
            String row = data[i];
            int old_length = row.length();
            for (int j = old_length; j < longest; j ++) {
                row = " " + row;
            }
            outstr += row;
            if (i != data.length - 1) {
                outstr += "\n";
            }
        }
        return outstr;
    }
}
