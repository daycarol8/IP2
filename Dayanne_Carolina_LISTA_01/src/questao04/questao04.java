package questao04;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class questao04 {
    static int workingDays(LocalDate date1, LocalDate date2){
        LocalDate day = date1;
        int daysBetween = 0;
        while(day.isBefore(date2)){
            DayOfWeek d1 = day.getDayOfWeek();
            if(d1 != DayOfWeek.SATURDAY && d1 != DayOfWeek.SUNDAY){
                daysBetween++;
            }
            day = day.plusDays(1);
        }

        return daysBetween;
    }

    public static void main(String[] args) {

        //a
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma data no formato --/--/----: ");
        String userDate = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(userDate, formatter);

        //b
        LocalDate now = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(date, now);
        System.out.println("\nDiferença da data digitada ate o dia atual: "+daysBetween);

        //c
        date = date.plusDays(110);
        System.out.println("\nData digitada + 110 dias: "+ date);

        //d
        date = date.withMonth(8);

        //e
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("\n"+formatter2.format(date));

        //f
        System.out.println("\nDigite a primeira data no fomarto --/--/----: ");
        String userDate1 = scanner.nextLine();
        System.out.println("Digite a segunda data no fomarto --/--/----: ");
        String userDate2 = scanner.nextLine();

        LocalDate date1 = LocalDate.parse(userDate1, formatter);
        LocalDate date2 = LocalDate.parse(userDate2, formatter);

        int workingDaysInBetween = workingDays(date1, date2);
        System.out.println("Dias uteis entre as duas datas: " + workingDaysInBetween);
    }
}
