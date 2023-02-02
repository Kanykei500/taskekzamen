package peaksoft;

import peaksoft.config.Config;
import peaksoft.entity.Category;
import peaksoft.entity.Company;
import peaksoft.entity.Product;
import peaksoft.service.*;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(Config.getEntityManagerFactory());
        CategoryService categoryService=new CategoryServiceImpl();
        CompanyService companyService=new CompanyServiceImpl();
        ProductService productService= new ProductServiceImpl();
        while (true){
            System.out.println("""
                    ~~~~~~~~~~Category~~~~~~~~~~~
                    1.save
                    2.get all product group by category name
                    
                    ~~~~~~~~~Company~~~~~~~
                    3.save
                    4.delete by id
                    5.update
                    
                    ~~~~~~~~~Product~~~~~~~
                    6.save
                    7.find all products by company id
                    8.delete
                    
                    write command:
                    """);
            Scanner scanner=new Scanner(System.in);
            int number=scanner.nextInt();
            switch (number) {
                case 1 -> {
                    System.out.println(categoryService.save(new Category("Drink")));
                    System.out.println(categoryService.save(new Category("Fruit")));
                    System.out.println(categoryService.save(new Category("Ice")));
                }
                case 2 -> System.out.println(categoryService.getAllProductGroupByCategoryName("Ihlas"));
                case 3 -> {
                    System.out.println(companyService.save(new Company("Munara", "Kyrgyzstan")));
                    System.out.println(companyService.save(new Company("Ainur", "Kyrgyzstan")));
                    System.out.println(companyService.save(new Company("GlobalKompas", "Kyrgyzstan")));
                }
                case 4 -> System.out.println(companyService.deleteById(3L));
                case 5 -> System.out.println(companyService.update(2L,
                        new Company("Ihlas", "USA")));
                case 6 -> {
                    System.out.println(productService.save(1L, 1L,
                            new Product("Potato", 100, LocalDate.of(2023, 1, 30))));
                 //   System.out.println(productService.save(3L, 7L,
                    //        new Product("IceCream", 200, LocalDate.of(2023, 1, 23))));
                 //   System.out.println(productService.save(3L, 3L,
                        //    new Product("Juice", 90, LocalDate.of(2023, 1, 31))));
                }
                case 7 -> System.out.println(productService.findAllProductsByCompanyId(1L));
                case 8 -> productService.delete(102L);
            }
        }











    }
}
