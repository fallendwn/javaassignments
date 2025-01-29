package fourth;
import fourth.librarydb;
import fourth.editiondb;
import fourth.departamentdb;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class gui {



    public static void main(String[] args) {
        librarydb librarydb1 = new librarydb();
        departamentdb departamentdb1 = new departamentdb();
        editiondb editiondb1 = new editiondb();



        JFrame frame = new JFrame("Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout(20, 20));

        JPanel centerPanel = new JPanel();


        //кнопки
        JButton add_lib = new JButton("Add Library");
        JButton remove_lib = new JButton("Remove Library");
        JButton add_department = new JButton("Add Department");
        JButton remove_department = new JButton("Remove Department");
        JButton add_edition = new JButton("Add Edition");
        JButton remove_edition = new JButton("Remove Edition");
        JButton find_edition = new JButton("Find Edition");
        JButton lib_get_info = new JButton("Get Lib Info");
        JButton depart_get_info = new JButton("Get Department Info");
        JButton ed_get_info = new JButton("Get Edition Info");

        //панельки,чтобы работать с ними
        JPanel library_panel = new JPanel(new BorderLayout());
        JPanel department_panel = new JPanel(new BorderLayout());
        JPanel edition_panel = new JPanel(new BorderLayout());



        //панельки для скролла отказался от идеи, все и так прекрасно работает ...
//        JPanel scroll_library = new JPanel();
//        JPanel scroll_edition = new JPanel();
//        JPanel scroll_departament = new JPanel();

        //создаю скроллы и добавляю их

        //LIBRARY
        DefaultListModel<String> libs_default = new DefaultListModel<>();
        libs_default.addAll(librarydb1.getAll());
        JList<String> libs_name_list = new JList<>();
        libs_name_list.setModel(libs_default);
        JScrollPane library_scroll = new JScrollPane(libs_name_list);


        //DEPARTAMENT
        DefaultListModel<String> departaments_default = new DefaultListModel<>();
        ArrayList<String> genre_names = new ArrayList<>();
        ArrayList<Integer> number_of_editions = new ArrayList<>();
        ArrayList<Integer> number_of_library = new ArrayList<>();

        //Получил в ответ РезултСет, который преобразую в 3 разных ArrayList;
        ResultSet rs1 = departamentdb1.getAll();
        try{
            while(rs1.next()){
                genre_names.add(rs1.getString("genre_name"));
                number_of_editions.add(rs1.getInt("number_of_editions"));
                number_of_library.add(rs1.getInt("library_id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        departaments_default.addAll(genre_names);
        JList<String> departaments_name_list = new JList<>(departaments_default);
        JScrollPane departament_pane = new JScrollPane(departaments_name_list);
        //scroll_departament.add(departament_pane);

        //EDITION
        DefaultListModel<String> editions_default = new DefaultListModel<>();
        ArrayList<String> edition_names = new ArrayList<>();
        ArrayList<String> edition_author = new ArrayList<>();
        ArrayList<Integer> edition_year = new ArrayList<>();
        ArrayList<Integer> departament_id = new ArrayList<>();
        ResultSet rs2 = editiondb1.getAll();
        try{
            while (rs2.next()){
                edition_names.add(rs2.getString("edition_name"));
                edition_author.add(rs2.getString("edition_author"));
                edition_year.add(rs2.getInt("edition_year"));
                departament_id.add(rs2.getInt("departament_id"));


            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        editions_default.addAll(edition_names);
        JList<String> edition_name_list = new JList<>(editions_default);
        JScrollPane edition_pane = new JScrollPane(edition_name_list);


        //Размеры панелек

        library_panel.setPreferredSize(new Dimension(300,700));
        department_panel.setPreferredSize(new Dimension(300,700));
        edition_panel.setPreferredSize(new Dimension(300,700));

        //добавляю панельки на фрейм

        centerPanel.add(library_panel);
        centerPanel.add(department_panel);
        centerPanel.add(edition_panel);

        frame.add(centerPanel, BorderLayout.SOUTH);

        //панельки, для кнопок отдельно
        JPanel library_buttons_panel = new JPanel();
        JPanel edition_buttons_panel = new JPanel();
        JPanel department_buttons_panel = new JPanel();


        //добавляю кнопки в панельки
        //LIBRARY
        library_buttons_panel.add(add_lib);
        library_buttons_panel.add(remove_lib);
        library_buttons_panel.add(lib_get_info);

        //DEPARTAMENT
        department_buttons_panel.add(add_department);
        department_buttons_panel.add(remove_department);
        department_buttons_panel.add(depart_get_info);

        //EDITION
        edition_buttons_panel.add(add_edition);
        edition_buttons_panel.add(remove_edition);
        edition_buttons_panel.add(find_edition);
        edition_buttons_panel.add(ed_get_info);

        //добавляю все на панель
        //Library
        library_panel.add(library_buttons_panel,BorderLayout.CENTER);
        library_panel.add(library_scroll,BorderLayout.NORTH);
        //Departament
        department_panel.add(department_buttons_panel,BorderLayout.CENTER);
        department_panel.add(departament_pane, BorderLayout.NORTH);
        //Edition
        edition_panel.add(edition_buttons_panel, BorderLayout.CENTER);
        edition_panel.add(edition_pane, BorderLayout.NORTH);




        add_lib.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Add Library");
                frame.setSize(700, 300);
                JLabel genre_name = new JLabel("Enter Library Name: ");
                JTextField name = new JTextField(30);
                JPanel hold = new JPanel();
                JButton submit = new JButton("Submit!");
                hold.add(genre_name);
                hold.add(name);
                hold.add(submit);
                frame.add(hold, BorderLayout.NORTH);
                frame.setVisible(true);
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!name.getText().isEmpty()){
                            librarydb1.add_new(name.getText());
                            libs_default.clear();
                            libs_default.addAll(librarydb1.getAll());
                            libs_name_list.revalidate();
                            libs_name_list.repaint();

                        }
                    }
                });


            }
        });

        remove_lib.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String get_name = libs_name_list.getSelectedValue();
                librarydb1.remove(get_name);
                libs_default.clear();
                libs_default.addAll(librarydb1.getAll());
                libs_name_list.revalidate();
                libs_name_list.repaint();
            }
        });

        lib_get_info.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Library Info");
                frame.setSize(700, 300);


                String library_name = libs_name_list.getSelectedValue();
                JLabel genre_name = new JLabel("Library Name: %s".formatted(library_name));
                DefaultListModel list_of_names = new DefaultListModel();
                System.out.print(librarydb1.getAllDepartaments(library_name));
                list_of_names.addAll(librarydb1.getAllDepartaments(library_name));
                JPanel hold = new JPanel();
                JList<String> jstring_names_lib = new JList<>(list_of_names);
                JScrollPane jstring_names_pane = new JScrollPane(jstring_names_lib);
                jstring_names_pane.setPreferredSize(new Dimension(500,200));
                hold.add(genre_name, BorderLayout.NORTH);
                hold.add(jstring_names_pane, BorderLayout.CENTER);
                frame.add(hold, BorderLayout.NORTH);
                frame.setVisible(true);




            }
        });
        add_department.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Add Departament");
                frame.setSize(700, 300);


                JLabel genre_name = new JLabel("Enter Genre Name: ");
                JTextField name = new JTextField(30);
                JLabel libtitle = new JLabel("Enter Library Name: ");
                JTextField libname = new JTextField(30);

                JPanel hold = new JPanel();
                JButton submit = new JButton("Submit!");

                hold.setLayout(new GridLayout(4, 2));

                hold.add(genre_name);
                hold.add(name);
                hold.add(libtitle);
                hold.add(libname);
                hold.add(submit);

                frame.add(hold, BorderLayout.CENTER);
                frame.setVisible(true);
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!name.getText().isEmpty() && !libname.getText().isEmpty()) {
                            departamentdb1.add_new(name.getText(), 0, libname.getText());
                            departaments_default.clear();
                            ResultSet resultSet = departamentdb1.getAll();
                            ArrayList<String> names = new ArrayList<>();
                            try{
                                while (resultSet.next()){
                                    names.add(resultSet.getString("genre_name"));

                                }

                            }
                            catch (Exception e1){
                                e1.printStackTrace();
                            }
                            departaments_default.addAll(names);
                            departaments_name_list.revalidate();
                            departaments_name_list.repaint();
                            frame.setVisible(true);
                        }
                    }
                });
            }
        });

        remove_department.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    String get_name = departaments_name_list.getSelectedValue();
                    departamentdb1.remove(get_name);
                    departaments_default.clear();
                    ResultSet resultSet = departamentdb1.getAll();
                    ArrayList<String> names = new ArrayList<>();
                    try{
                        while (resultSet.next()){
                            names.add(resultSet.getString("genre_name"));

                        }

                    }
                    catch (Exception e1){
                        e1.printStackTrace();
                    }
                    departaments_default.addAll(names);
                    departaments_name_list.revalidate();
                    departaments_name_list.repaint();

            }
        });

        depart_get_info.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Departament Info");
                frame.setSize(700, 300);
                String departament_name = departaments_name_list.getSelectedValue();
                JLabel genre_name = new JLabel("Departament Name: %s".formatted(departament_name));
                int number_= departamentdb1.getSpecific(departament_name);
                JLabel editions_number = new JLabel("Number of editions: %d".formatted(number_));
                DefaultListModel list_of_names = new DefaultListModel();
                list_of_names.addAll(departamentdb1.get_all_editions(departament_name));
                JPanel hold = new JPanel();
                JList<String> jstring_names_lib = new JList<>(list_of_names);
                JScrollPane jstring_names_pane = new JScrollPane(jstring_names_lib);
                jstring_names_pane.setPreferredSize(new Dimension(500,200));
                hold.add(genre_name, BorderLayout.NORTH);
                hold.add(editions_number, BorderLayout.NORTH );
                hold.add(jstring_names_pane, BorderLayout.CENTER);
                frame.add(hold, BorderLayout.NORTH);
                frame.setVisible(true);

            }
        });

        add_edition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame editionFrame = new JFrame("Add Edition");
                editionFrame.setSize(700, 300);

                JLabel title = new JLabel("Enter Edition Name: ");
                JTextField name = new JTextField(30);

                JLabel author_title = new JLabel("Enter Author Name: ");
                JTextField author_name = new JTextField(30);

                JLabel edition_year_title = new JLabel("Enter Year: ");
                JTextField edition_year = new JTextField(30);

                JLabel departament_name_title = new JLabel("Enter Department Name: ");
                JTextField departament_name = new JTextField(30);

                JPanel hold = new JPanel();
                JButton submit = new JButton("Submit!");

                hold.setLayout(new GridLayout(5, 2));

                hold.add(title);
                hold.add(name);
                hold.add(author_title);
                hold.add(author_name);
                hold.add(edition_year_title);
                hold.add(edition_year);
                hold.add(departament_name_title);
                hold.add(departament_name);
                hold.add(submit);

                editionFrame.add(hold, BorderLayout.CENTER);
                editionFrame.setVisible(true);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!name.getText().isEmpty() && !edition_year.getText().isEmpty() && !author_name.getText().isEmpty() && !departament_name.getText().isEmpty()) {
                            String input = edition_year.getText();
                            try {
                                int number = Integer.parseInt(input);
                                editiondb1.add_new(name.getText(), author_name.getText(), number, departament_name.getText());
                                editiondb1.update_departament(departament_name.getText(), true);
                                editions_default.clear();
                                ResultSet resultSet = editiondb1.getAll();
                                ArrayList<String> names = new ArrayList<>();
                                try{
                                    while (resultSet.next()){
                                        names.add(resultSet.getString("edition_name"));
                                    }

                                }
                                catch (Exception e1){
                                    e1.printStackTrace();
                                }
                                editions_default.addAll(names);
                                edition_name_list.revalidate();
                                edition_name_list.repaint();
                                frame.setVisible(true);

                            } catch (NumberFormatException ex) {
                                edition_year.setText("Invalid number!");
                            }
                        }
                    }
                });


            }
        });
        remove_edition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String get_name = edition_name_list.getSelectedValue();

                String departament_related_name = editiondb1.get_name_of_related_departament(get_name);

                editiondb1.update_departament(departament_related_name, false);

                editiondb1.remove(get_name);
                editions_default.clear();
                ResultSet resultSet = editiondb1.getAll();
                ArrayList<String> names = new ArrayList<>();
                try{
                    while (resultSet.next()){
                        names.add(resultSet.getString("edition_name"));

                    }

                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
                editions_default.addAll(names);
                edition_name_list.revalidate();
                edition_name_list.repaint();

            }
        });

        ed_get_info.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Edition Info");
                frame.setSize(700, 300);
                String edition_name = edition_name_list.getSelectedValue();
                JLabel genre_name = new JLabel("Edition Name: %s".formatted(edition_name));
                int year_number_= editiondb1.getSpecific(edition_name);
                String author_name = editiondb1.getSpecificAuthor(edition_name);
                JLabel editions_number = new JLabel("Year of editions: %d".formatted(year_number_));
                JLabel author_nameLabel = new JLabel("Author name : %s".formatted(author_name));
                JLabel departament_label = new JLabel("Departament name : %s".formatted(editiondb1.get_name_of_related_departament(edition_name)));
                JLabel library_label  = new JLabel("Library name : %s".formatted(editiondb1.get_name_of_related_library(edition_name)));
                DefaultListModel list_of_names = new DefaultListModel();
                JPanel hold = new JPanel();
                hold.add(genre_name, BorderLayout.NORTH);
                hold.add(editions_number, BorderLayout.NORTH );
                hold.add(author_nameLabel, BorderLayout.NORTH);
                hold.add(departament_label, BorderLayout.NORTH);
                hold.add(library_label, BorderLayout.NORTH);
                frame.add(hold, BorderLayout.NORTH);
                frame.setVisible(true);

            }
        });
        find_edition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Search by year");
                frame.setSize(700, 300);
                JPanel hold = new JPanel();
                JButton search = new JButton("Search");
                JLabel edition_year = new JLabel("Enter year: ");
                JTextField year = new JTextField(10);
                hold.add(edition_year, BorderLayout.NORTH);
                hold.add(year, BorderLayout.NORTH);
                hold.add(search, BorderLayout.SOUTH);
                frame.add(hold, BorderLayout.CENTER);
                frame.setVisible(true);
                search.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!edition_year.getText().isEmpty()) {
                            String input = year.getText();
                            try {
                                int number = Integer.parseInt(input);
                                ArrayList<String> edition_names = new ArrayList<String>(editiondb1.year_return(number));
                                for(int i = 0 ; i < edition_names.size() ; i++){
                                    edition_names.set(i, edition_names.get(i) + " departament: %s".formatted(editiondb1.get_name_of_related_departament(edition_names.get(i))));
                                }
                                JFrame newFrame = new JFrame("Everything we could find!");
                                newFrame.setSize(700, 300);
                                DefaultListModel list_of_names = new DefaultListModel();
                                list_of_names.addAll(edition_names);
                                JList<String> founded = new JList<>(list_of_names);
                                JScrollPane founded_scroll = new JScrollPane(founded);
//                                founded_scroll.setPreferredSize(new Dimension(400, 300));
                                newFrame.add(founded_scroll);
                                newFrame.setVisible(true);




                            } catch (NumberFormatException ex) {
                                year.setText("Invalid number!");
                            }
                        }
                    }
                });

            }
        });

    }
}