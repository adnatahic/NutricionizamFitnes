package com.planiprogram.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planiprogram.module.*;
import com.planiprogram.repository.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private OsobaRepository osobaRepository;
    

    
    @Autowired
    private KorisnikRepository korisnikRepository;
    
    @Autowired
    private TrenerRepository trenerRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Osoba o = osobaRepository.findByUsername(username);
        
        int idOsobe = o.getId();
        List<Korisnik> korisnici = (List<Korisnik>) korisnikRepository.findAll();
        List<Trener> treneri = (List<Trener>) trenerRepository.findAll();
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        Boolean korisnik, trener = false;
        
        for(int i = 0; i < korisnici.size(); i++)
        {
        	if(korisnici.get(i).getOsoba().getId() == idOsobe)
        	{
        		System.out.println("KORISNIK");
        		grantedAuthorities.add(new SimpleGrantedAuthority("KORISNIK"));
                return new org.springframework.security.core.userdetails.User(o.getUsername(), o.getPassword(), grantedAuthorities);
        	}
        }
        
        for(int i = 0; i < treneri.size(); i++)
        {
        	if(treneri.get(i).getOsoba().getId() == idOsobe)
        	{
        		System.out.println("TRENER");
        		grantedAuthorities.add(new SimpleGrantedAuthority("TRENER"));
                return new org.springframework.security.core.userdetails.User(o.getUsername(), o.getPassword(), grantedAuthorities);
        	}
        }
        
        
        grantedAuthorities.add(new SimpleGrantedAuthority("DEFAULT"));
        return new org.springframework.security.core.userdetails.User(o.getUsername(), o.getPassword(), grantedAuthorities);
        
    }
}
