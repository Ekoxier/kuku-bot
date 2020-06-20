package me.kuku.yuq.dao

import com.icecreamqaq.yudb.jpa.hibernate.HibernateDao
import me.kuku.yuq.entity.SteamEntity

class SteamDao: HibernateDao<SteamEntity, Int>() {

    fun findByQQ(qq: Long): SteamEntity? {
        val session = this.getSession()
        val query = session.createQuery("from SteamEntity where qq = :qq")
        query.setLong("qq", qq)
        val result = query.uniqueResult()
        return if (result == null) null else result as SteamEntity
    }

    fun singleSave(entity: SteamEntity) {
        val session = this.getSession()
        val transaction = session.beginTransaction()
        session.save(entity)
        transaction.commit()
    }

}