package com.example.task02;

public class DiscountBill extends Bill {
    private final double discountPercentage;

    public DiscountBill(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть от 0 до 100");
        }
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public long getDiscountAmount() {
        long totalPrice = super.getPrice();  // из родительского класса
        return (long) (totalPrice * discountPercentage / 100);
    }

    // Переопределение метода getPrice() для расчёта итоговой суммы со скидкой
    @Override
    public long getPrice() {
        long totalPrice = super.getPrice();  // Полная сумма без скидки
        long discount = getDiscountAmount();  // Сумма скидки
        return totalPrice - discount;  // Итоговая сумма со скидкой
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nПроцент скидки: ").append(discountPercentage).append('%');
        sb.append("\nСумма скидки: ").append(getDiscountAmount());
        sb.append("\nИтоговая сумма со скидкой: ").append(getPrice());
        return sb.toString();
    }
}
