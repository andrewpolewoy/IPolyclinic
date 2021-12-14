package com.it_academy.jd2.model.utils;//package by.it_academy.jd2.model.utils;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
///** Класс для установки соединения с базой данных */
//public class HibernateCreatorDemo {
//
//    /** Создание объекта SessionFactory */
//    private static SessionFactory sessionFactory = buildFactory();
//
//    /**
//     * Класс для создания сессии и получения метаданных
//     * @throws RuntimeException ошибка при созданнии сессии
//     * @see RuntimeException
//     */
//    private static SessionFactory buildFactory() {
//        try {
//            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                    .configure("hibernate.cfg.xml")
//                    .build();
//
//            Metadata metadata = new MetadataSources(serviceRegistry)
//                    .getMetadataBuilder()
//                    .build();
//
//            return metadata.getSessionFactoryBuilder().build();
//        } catch (Throwable t) {
//            throw new RuntimeException(t);
//        }
//    }
//
//    /** Получает экземпляр класса SessionFactory
//     * @return экземпляр собственного класса {@link SessionFactory}
//     */
//    public static SessionFactory getInstance() {
//        return sessionFactory;
//    }
//}