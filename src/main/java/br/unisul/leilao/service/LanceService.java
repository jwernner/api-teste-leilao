package br.unisul.leilao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.leilao.dto.NovoLanceDto;
import br.unisul.leilao.model.Lance;
import br.unisul.leilao.model.Leilao;
import br.unisul.leilao.model.Usuario;
import br.unisul.leilao.repositories.LanceRepository;
import br.unisul.leilao.repositories.LeilaoRepository;
import br.unisul.leilao.repositories.UsuarioRepository;

@Service
public class LanceService {

	@Autowired
	private LanceRepository lances;

	@Autowired
	private UsuarioRepository usuarios;

	@Autowired
	private LeilaoRepository leiloes;

	public boolean propoeLance(NovoLanceDto lanceDto, String nomeUsuario) {

		Usuario usuario = usuarios.getUserByUsername(nomeUsuario);
		Lance lance = lanceDto.toLance(usuario);

		Leilao leilao = this.getLeilao(lanceDto.getLeilaoId());

		if (leilao.propoe(lance)) {
			lances.save(lance);
			return true;
		}

		return false;
	}

	public Leilao getLeilao(Long leilaoId) {
		return leiloes.getOne(leilaoId);
	}

}