package com.iris.pbms.daosimpl;



import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



import com.iris.pbms.daos.UserDao;

import com.iris.pbms.model.UserTable;



@Repository("userDao")

public class UserDaosImpl implements UserDao {



	@Autowired

	SessionFactory sessionFactory;

	

	public UserTable validateUser(int userId, String password) {

		try {

			Session session=sessionFactory.getCurrentSession();

			UserTable userObj=session.get(UserTable.class, userId);

			

			//If object is found with the given ID 

			if(userObj!=null){

				if(userObj.getPassword().equals(password)){

					return userObj;

				}

			}

			}

			catch(Exception e){

				e.printStackTrace();

			}

			return null;

		

	}

	public UserTable getUserById(int userId) {

		try {

			Session session=sessionFactory.getCurrentSession();

			UserTable userObj=session.get(UserTable.class, userId);

			return userObj;

			

			}

			catch(Exception e){

				e.printStackTrace();

			}

			return null;

		}

	}