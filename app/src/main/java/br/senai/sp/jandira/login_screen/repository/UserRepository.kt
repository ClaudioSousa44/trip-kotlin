package br.senai.sp.jandira.login_screen.repository

import android.content.Context
import br.senai.sp.jandira.login_screen.DAO.TripDb
import br.senai.sp.jandira.login_screen.model.User

class UserRepository(context: Context) {

    private   val db = TripDb.getDataBase(context)

    fun save(user: User): Long{
        return  db.userDao().save(user)
    }

    fun findUserByEmail(email: String): User {
        return db.userDao().findUserByEmail(email)
    }

    fun authenticate(email: String, password: String): User{
        return db.userDao().authenticate(email,password)
    }
}