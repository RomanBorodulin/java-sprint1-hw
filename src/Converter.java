class Converter {
    // Преобразования шагов в км и ккал
    static final double CONVERSION_FACTOR_OF_STEP_TO_KM = 0.00075;
    static final double CONVERSION_FACTOR_OF_STEP_TO_KCAL = 0.05;

    int convertToKm(int steps) {
        // 1 шаг = 75 см
        return (int) (steps * CONVERSION_FACTOR_OF_STEP_TO_KM);
    }

    int convertStepsToKilocalories(int steps) {
        // 1 шаг = 0.05 Ккал
        return (int) (steps * CONVERSION_FACTOR_OF_STEP_TO_KCAL);
    }
}
