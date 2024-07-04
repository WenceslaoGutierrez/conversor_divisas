public record Divisa(String base_code, String target_code,double conversion_rate,double conversion_result) {
    @Override
    public String toString() {
        return "El valor de " + (conversion_result/conversion_rate) +" " +base_code+" son "+conversion_result+" "+target_code;
    }
}

