package url.shortener

import java.sql.DriverManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException


object DB {
    init {
        DriverManager.getConnection("jdbc:sqlite:shortener.db").use { connection ->
            val sqlString = """CREATE TABLE IF NOT EXISTS links (key TEXT PRIMARY KEY, original_url TEXT NOT NULL)"""
            updateSQL(sqlString, connection)
        }
    }

    fun add(originalUrl: String, key: String): Boolean {
        return false
    }

    fun find(key: String): ShortURL {

    }

    private fun updateSQL(sql: String, connection: Connection) {
        connection.createStatement().use { statement ->
            statement.executeUpdate(sql)
        }
    }

    private fun executeUpdate(sql: String, vararg params: String): Boolean {
        try {
            DriverManager.getConnection("jdbc:sqlite:shortener.db").use { connection ->
                connection.prepareStatement(sql).use { statement ->
                    params.forEachIndexed { index, param ->
                        statement.setString(index + 1, param)
                    }

                    return statement.executeUpdate() > 0
                }
            }
        } catch (e: SQLException) {
            return false
        }
    }
} 