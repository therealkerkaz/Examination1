public class Main {
    public static void main(String[] args) {
        MyClass validator = new MyClass();
        String xml = "<h2>\n" +
                "\n" +
                "<h3>\n" +
                "<a></a>\n" +
                "</h3>\n" +
                "\n" +
                "<h4>\n" +
                "\n" +
                "</h4>\n" +
                "\n" +
                "\n" +
                "<h5>\n" +
                "</h5>\n" +
                "\n" +
                "</h2>\n" +
                "\n" +
                "\n" +
                "<bode>\n" +
                "\n" +
                "<h6>\n" +
                "\n" +
                "</h6>\n" +
                "\n" +
                "\n" +
                "</bode>";
        boolean result = validator.ValidateSolushon(xml);
        System.out.println(result);
    }
}
