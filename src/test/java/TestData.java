import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.number().digits(10);
    String sex = faker.options().option("Male", "Female", "Other");
    String year = String.valueOf(faker.number().numberBetween(1990,2023));
    String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    String day = String.valueOf(faker.number().numberBetween(1,28));
    String subject = faker.options().option("Computer Science", "Commerce", "Accounting",
            "Economics", "Social Studies", "Civics", "English", "Arts", "History", "Maths");
    String hobbies = faker.options().option("Sports", "Reading", "Music");
    String fileName = "Untitled.jpg";
    String address = faker.address().fullAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String city = getCity();

    private String getCity(){
        String cityItem = null;

        if (state.equals("NCR")) {
            cityItem = faker.options().option("Delhi", "Gurgaon", "Noida");
        }

        if (state.equals("Uttar Pradesh")) {
            cityItem = faker.options().option("Agra", "Lucknow", "Merrut");
        }

        if (state.equals("Haryana")) {
            cityItem = cityItem = faker.options().option("Karnal", "Panipat");
        }

        if (state.equals("Rajasthan")) {
            cityItem = faker.options().option("Jaipur", "Jaiselmer");
        }
        return cityItem;
    }
}
