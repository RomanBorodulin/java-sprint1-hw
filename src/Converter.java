class Converter {
    // Преобразования шагов в км и ккал
    int convertToKm(int steps) {
        // 1 шаг = 75 см
        return (int) (steps * 0.00075);
    }

    int convertStepsToKilocalories(int steps) {
        // 1 шаг = 0.05 Ккал
        return (int) (steps * 0.05);
    }
}
