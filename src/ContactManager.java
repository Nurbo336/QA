import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactManager {
    Scanner sc = new Scanner(System.in);
    private Contact[] contacts = new Contact[100];
    private int count;

    void action() {
        while (true) {
            System.out.println("***********МЕНЮ**********************");
            System.out.println("*1 - Создать новый контакт          *");
            System.out.println("*2 - Просмотр контактов             *");
            System.out.println("*3 - Обновить контакты              *");
            System.out.println("*4 - Удалить контакты               *");
            System.out.println("*5 - Просмотр информации о контактов*");
            System.out.println("*6 - Поиск контактов                *");
            System.out.println("*7 - Выход                          *");
            System.out.println("**************************************");
            System.out.println("\nВыберите действие:");
            try {
                int code = sc.nextInt();
                sc.nextLine();

                switch (code) {
                    case 1:
                        addContact();
                        break;
                    case 2:
                        displayAllContact();
                        break;
                    case 3:
                        editContact();
                        break;
                    case 4:
                        deleteContact();
                        break;
                    case 5:
                        readContact();
                        break;
                    case 6:
                        searchContact();
                        break;
                    default:
                        System.out.println("Некорректный ввод. Пожалуйста, выберите введите еще раз.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Ошибка ввода, пожалуйста введите корректное число");
                sc.nextLine();
            }
        }
    }

    public void addContact() {
        try {
            System.out.println("Введите имя контакта");
            String name = sc.nextLine();
            System.out.println("Введите фамилию контакта");
            String surname = sc.nextLine();
            System.out.println("Введите номер телефона контакта");
            String phoneNumber = sc.nextLine();
            System.out.println("Введите адрес электронной почты");
            String email = sc.nextLine();
            contacts[count] = new Contact(name, surname, phoneNumber, email);
            count++;
            System.out.println("Контакт успешно сохранен!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Превышен лимит контактов");
        } catch (InputMismatchException e) {
            System.err.println("Некорректные данные контакта");
        }
    }

    public void displayAllContact() {
        if (count == 0) {
            System.err.println("Список контактов пуст");
        } else {
            for (int i = 0; i < count; i++) {
                Contact contact = contacts[i];
                String name = contact.getName();
                System.out.println(i + 1 + ":" + name);
            }
        }
    }

    public void readContact() {
        if (count == 0) {
            System.err.println("Список контактов пуст");
        } else {
            System.out.println("Выберите контакт");
            for (int i = 0; i < count; i++) {
                Contact contact = contacts[i];
                String name = contact.getName();
                System.out.println(i + 1 + ":" + name);
            }

            try {
                int index = sc.nextInt() - 1;
                while (index < 0 || index >= count) {
                    System.out.println("Неверный индекс контакта. Введите снова: ");
                    index = sc.nextInt();
                }
                Contact selectContact = contacts[index];
                String name = selectContact.getName();
                String surname = selectContact.getSurname();
                String number = selectContact.getPhoneNumber();
                String email = selectContact.getEmail();
                System.out.println("\n" + "Имя: " + name + "\n" + "Фамилия: " + surname + "\n" +
                        "Телефон номер: " + number + "\n" + "Электронная почта: " + email);
            } catch (InputMismatchException e) {
                System.err.println("Ошибка ввода, пожалуйста введите корректное число");
            }
        }
    }

    public void editContact() {
        System.out.println("Выберите контакт");
        for (int i = 0; i < count; i++) {
            Contact contact = contacts[i];
            String name = contact.getName();
            System.out.println(i + 1 + ":" + name);
        }
        try {
            int index = sc.nextInt() - 1;
            while (index < 0 || index >= count) {
                System.out.println("Неверный индекс контакта. Введите снова: ");
                index = sc.nextInt() - 1;
            }
            Contact selectContact = contacts[index];
            if (selectContact != null) {
                System.out.println("Выберите что изменить");
                System.out.println("1.Имя");
                System.out.println("2.Фамилия");
                System.out.println("3.Номер телефона");
                System.out.println("4.Электронная почта");
                System.out.println("5.Выход");
                int value = sc.nextInt();
                sc.nextLine();
                switch (value) {
                    case 1:
                        System.out.print("Введите новое имя контакта: ");
                        String newName = sc.next();
                        contacts[index].setName(newName);
                        System.out.println("Контакт обновлен.");
                        break;
                    case 2:
                        System.out.print("Введите новую фамилию контакта: ");
                        String newSurname = sc.next();
                        contacts[index].setSurname(newSurname);
                        System.out.println("Контакт обновлен.");
                        break;
                    case 3:
                        System.out.print("Введите новый номер контакта: ");
                        String newNum = sc.next();
                        contacts[index].setPhoneNumber(newNum);
                        System.out.println("Контакт обновлен.");
                        break;
                    case 4:
                        System.out.print("Введите новый электронный адрес");
                        String newEmail = sc.nextLine();
                        contacts[index].setEmail(newEmail);
                        System.out.println("Контакт обновлен.");
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Не корректный ввод");
                        break;
                }
            } else {
                System.out.println("Выбранный контакт отсутствует");
            }
        } catch (InputMismatchException e) {
            System.err.println("Ошибка ввода, пожалуйста введите корректное число");
        }
        for (int i = 0; i < contacts.length; i++) {
            Contact contact = contacts[i];
            String name = contact.getName();
            System.out.println(i + 1 + ":" + " Имя: " + name);
        }
    }

    public void deleteContact() {
        System.out.print("Выберите контакт - ");
        try {
            int index = sc.nextInt() - 1;
            while (index < 0 || index >= count) {
                System.out.println("Неверный индекс контакта. Введите снова: ");
                index = sc.nextInt();
            }
            if (contacts[index] != null) {
                contacts[index].setEmail(null);
                contacts[index].setName(null);
                contacts[index].setPhoneNumber(null);
                contacts[index].setSurname(null);
                System.out.println("Контакт удален успешно");
            } else {
                System.out.println("Контакт не существует");
            }
        } catch (InputMismatchException e) {
            System.err.println("Ошибка ввода, пожалуйста введите корректное число");
        }
    }

    public void searchContact() {
        System.out.println("Введите имя контакта для поиска: ");
        try {
            String search = sc.nextLine();
            boolean found = false;

            for (Contact con : contacts) {
                if (con != null && con.getName().toLowerCase().contains(search.toLowerCase())) {
                    System.out.println("Контакт найден: " + con.getName() + " " + con.getSurname());
                    System.out.println("______________________________");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Контакт не найден");
            }
        } catch (NullPointerException e) {
            System.err.println("Некорректные данные контакта");
        }
    }
}
