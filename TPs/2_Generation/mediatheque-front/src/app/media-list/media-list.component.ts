import { Component, OnInit } from '@angular/core';
import { Media, MediaService } from '../core/api/v1';

@Component({
  selector: 'app-media-list',
  templateUrl: './media-list.component.html',
  styleUrls: ['./media-list.component.css']
})
export class MediaListComponent implements OnInit {

  medias: Media[]

  constructor(private mediaService: MediaService) { }

  ngOnInit() {
    this.mediaService.findAll().subscribe(res => this.medias = res)
  }

}
