package bzh.greta.bank.repository;

import bzh.greta.bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * L'interface JpaRepository va founir l'implémentation de nombreuses méthodes java
 * Derrière ces méthodes se trouvent du SQL
 * Vous n'avez pas à écrire du SQL, vous avez simplement à fournir deux infos à Jpa Repository :
 * - le type de l'entity : Account
 * - le type de son identifiant : Integer
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
