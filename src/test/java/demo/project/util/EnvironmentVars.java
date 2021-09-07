package demo.project.util;

import com.google.inject.internal.cglib.core.$ProcessArrayCallback;

public class EnvironmentVars {
    public static String getBaseURL(String env) {
        String base = "https://k51qryqov3.execute-api.ap-southeast-2.amazonaws.com/";

        switch (env.toLowerCase()) {
            case "staging":
                return base + "staging/";
            case "prod":
                return base + "prod/";
            default:
                return base + "dev/";
        }
    }

    public static String getMaker(String id) {
        switch (id) {
            case "c0bm09bgagshpkqbsuag":
                return "Lamborghini";
            case "c0bm09jgagshpkqbsuq0":
                return "Pagani";
            case "c0bm09jgagshpkqbsv00":
                return "Lancia";
            case "c0bm09bgagshpkqbsuk0":
                return "Alfa Romeo";
            case "c0bm09jgagshpkqbsusg":
                return "Bugatti";
            default:
                return null;
        }
    }

    public static Object getModel(String id) {
        switch (id) {
            case "c0bm09bgagshpkqbsuh0":
                return "Diablo";
            case "c0bm09bgagshpkqbsue0":
                return "Veneno";
            case "c0bm09bgagshpkqbsukg":
                return "Giulietta";
            case "c0bm09bgagshpkqbsum0":
                return "4c Spider";
            case "c0bm09jgagshpkqbsv2g":
                return "Rally 037";
            case "c0bm09jgagshpkqbsv0g":
                return "Deltac";
            case "c0bm09bgagshpkqbsud0":
                return "GALLARDO";
            case "c0bm09jgagshpkqbsuug":
                return "Chiron";
            case "c0bm09jgagshpkqbsv3g":
                return "Stratos";
            case "c0bm09jgagshpkqbsuqg":
                return "Zonda";
            case "c0bm09bgagshpkqbsuc0":
                return "AVENTADOR";
            case "c0bm09bgagshpkqbsung":
                return "Mito";
            case "c0bm09jgagshpkqbsut0":
                return "Veyron";
            case "c0bm09bgagshpkqbsup0":
                return "Guilia Quadrifoglio";
            case "c0bm09bgagshpkqbsuf0":
                return "Reventón";
            case "c0bm09bgagshpkqbsuj0":
                return "Miura";
            case "c0bm09jgagshpkqbsv1g":
                return "Ypsilon";
            case "c0bm09jgagshpkqbsurg":
                return "Huayra";
            case "c0bm09bgagshpkqbsug0":
                return "Murciélago";
            case "c0bm09bgagshpkqbsui0":
                return "Countach";
            case "c0bm09bgagshpkqbsub0":
                return "HURACÁN";
            default:
                return null;
        }
    }
}
